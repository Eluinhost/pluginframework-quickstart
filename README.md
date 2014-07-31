PluginFramework Quickstart Archetype
====================================

Maven Archetype for a PluginFramework Plugin.

What does it do?
----------------

This archetype sets up a basic plugin that uses the PluginFramework dependency.
It also creates a basic plugin class, service class and command class as examples.
Instructs Maven to compile for Java 6 to support every server that Bukkit supports.

### Dependencies added

#### Compile

- Bukkit, latest development version
- PluginFramework, 0.1 and shaded into the final JAR

#### Test

- JUnit
- Mockito
- PowerMockito
- AssertJ

To change the versions of any dependencies you can change the property for it in the pom.xml

Installation
------------

To install the archetype in your local repository execute following commands:

    git clone https://github.com/Eluinhost/pluginframework-quickstart.git
    cd pluginframework-quickstart
    mvn clean install

Create a project
----------------

Change into the directory you want your project to be inside and run the following

`mvn archetype:generate -DarchetypeGroupId=com.publicuhc.archetypes -DarchetypeArtifactId=pluginframework-quickstart -DarchetypeVersion=0.1-SNAPSHOT`

Answer the request parameters to finish creation