package de.esailors.gradle.canarybuild
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.artifacts.DependencyResolutionListener
import org.gradle.api.artifacts.ResolvableDependencies

class CanaryBuildPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.gradle.addListener(new DependencyResolutionListener() {
            @Override
            void beforeResolve(ResolvableDependencies dependencies) {
                 }

            @Override
            void afterResolve(ResolvableDependencies dependencies) {

            }
        })

        project.extensions.create("canarybuild", CanaryBuildPluginExtension)

        Task canaryBuildTask = project.tasks.create('buildCanary', CanaryBuildTask)
        //canaryBuildTask.dependsOn(project.tasks.getByName("build"))
        project.tasks.getByName("build") mustRunAfter canaryBuildTask

    }
}

