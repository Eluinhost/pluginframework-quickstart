pluginframework-archetype
=========================

Maven Archetype for a PluginFramework Plugin.

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