package scripts

plugins {
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            setUrl("https://maven.pkg.github.com/wmontwe/gradle-git-version")
            credentials {
                username = (project.findProperty("gpr.user")
                        ?: System.getenv("PACKAGE_REGISTRY_UPLOAD_USERNAME")).toString()
                password = (project.findProperty("gpr.key")
                        ?: System.getenv("PACKAGE_REGISTRY_UPLOAD_TOKEN")).toString()
            }
        }
    }

    publications {
        withType<MavenPublication> {
            groupId = "eu.upwolf.gradle.gitversion"

            pom {
                url.set("https://github.com/wmontwe/gradle-git-version")
                description.set("Gradle Git versioning plugin")
                inceptionYear.set("2021")

                licenses {
                    license {
                        name.set("Apache 2.0")
                        url.set("https://github.com/wmontwe/gradle-git-version/blob/develop/LICENSE")
                        distribution.set("repo")
                    }
                }

                scm {
                    val scmUrl = "git://github.com/wmontwe/gradle-git-version"
                    connection.set("scm:$scmUrl")
                    developerConnection.set("scm:$scmUrl")
                    url.set(scmUrl)
                }
            }
        }
    }
}
