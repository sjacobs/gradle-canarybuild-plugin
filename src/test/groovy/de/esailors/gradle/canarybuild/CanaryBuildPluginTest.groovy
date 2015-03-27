package de.esailors.gradle.canarybuild
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue
/**
 *
 */
class CanaryBuildPluginTest {

    @Test
    public void testThatApplyingThePluginAddsTheCanaryBuildTask() {
        Project project = ProjectBuilder.builder().build()
        project.tasks.create("build")
        project.tasks.create("jar", Jar)
        project.getPlugins().apply "canarybuild"

        assertTrue(project.tasks.buildCanary instanceof CanaryBuildTask)
    }

    @Test
    public void testThatCanaryBuildTaskCanBeExecuted() {
        Project project = ProjectBuilder.builder().build()
        project.tasks.create("build")
        project.tasks.create("jar", Jar)
        project.getPlugins().apply "canarybuild"

        def task = project.tasks.buildCanary

        task.actions.each { Action a ->
            a.execute(task)
        }
    }
}
