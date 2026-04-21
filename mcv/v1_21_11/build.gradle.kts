plugins {
    `java-library`
    id("io.papermc.paperweight.userdev")
}

dependencies {
    compileOnly(project(":core"))
    paperweight.paperDevBundle("1.21.11-R0.1-SNAPSHOT")
    // Workaround for paperweight-userdev 2.0.0-beta.21 requesting this transitive
    // adventure artifact with an empty version; pin it to the bundle's adventure version.
    compileOnly("net.kyori:adventure-text-serializer-ansi:4.26.1")
}

paperweight.reobfArtifactConfiguration = io.papermc.paperweight.userdev.ReobfArtifactConfiguration.REOBF_PRODUCTION

java {
    toolchain.languageVersion = JavaLanguageVersion.of(24)
}

tasks.compileJava {
    options.release = 21
}

tasks.assemble {
    dependsOn(tasks.reobfJar)
}