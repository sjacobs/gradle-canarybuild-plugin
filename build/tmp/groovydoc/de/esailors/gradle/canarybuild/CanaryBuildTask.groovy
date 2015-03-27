package de.esailors.gradle.canarybuild
import org.gradle.api.DefaultTask
import org.gradle.api.artifacts.ComponentMetadata
import org.gradle.api.artifacts.ComponentSelection
import org.gradle.api.artifacts.DependencyResolveDetails
import org.gradle.api.artifacts.ivy.IvyModuleDescriptor
import org.gradle.api.tasks.TaskAction
/**
 *
 */
class CanaryBuildTask extends DefaultTask {



    @TaskAction
    def build() {
        def onlyStable = project.canarybuild.onlyStable

        /*if (onlyStable == true) {
            println "will use only stable releases because you set onlyStable=true"
        }*/

        project.configurations.all { config ->
            config.resolutionStrategy.eachDependency { DependencyResolveDetails details ->
                details.useVersion("+")
            }

            config.resolutionStrategy.componentSelection.all { ComponentSelection selection, IvyModuleDescriptor descriptor,  ComponentMetadata metadata ->
                println descriptor.branch + " -- " + metadata.status
                if (onlyStable == true) {
                    if (descriptor.branch != 'release' || metadata.status != 'milestone' || selection.candidate.version.endsWith("SNAPSHOT")) {
                        println "rejected: " + selection.candidate.module + ":" + selection.candidate.version
                        selection.reject("only milestone or release candidates are allowed!")
                    } else {
                        println selection.candidate.module + " -> " + selection.candidate.version
                    }
                }
            }
        }

    }
}