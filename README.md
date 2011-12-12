Le Compte Est Bon
=================

Vaadin / Scala / Google appengine project for LCEB
This is hosted on http://lceb-demo.appspot.com/

Goal
----

Find the operations' combination to use so as to get the expected result.

Ex of result : 
((25 * (7 * 5) => 35 
) => 875 
 + ((8 * 9) => 72 
 + 6) => 78 
) => 953 

Usage
-----

LCEB has been updated so as to use Maven, so here are some information on how to test/deploy the project using Maven, and also some tips regarding its integration in Eclipse IDE.

### Initialization of the environment

1. First of all, you'll have to get the project. Just clone using `git clone`.
2. As we're going to use Maven, you'll need to define some environment variables: `JAVA_HOME`, `SCALA_HOME`, and `M2_HOME`.
3. Don't forget to add `$JAVA_HOME/bin`, `$SCALA_HOME/bin` and `$M2_HOME/bin` in the `PATH` variable.
4. Then you'll have to install Google AppEngine SDK for Maven. Navigate to the root of the project, and run `mvn gae:unpack`.

### Testing the project

1. Using Maven, you just have to run `mvn gae:run` to test locally the project.
2. Note that depending on your operating system's configuration, you'll perhaps need to launch this command as root. (with something like `sudo mvn gae:run` for example).

### Deploying the project

1. In order to deploy the project, you'll have to use the `mvn gae:deploy` goal.
2. Please refer to the plugin's provider documentation for more information about the deployment: http://code.google.com/p/maven-gae-plugin/
	Some information about deploying can be found here: http://www.kindleit.net/maven_gae_plugin/maven-gae-plugin/deploy-mojo.html
	
### Eclipse IDE tips

If you want to use Eclipse IDE to contribute to this project, here are some tips for a basic configuration of the environment:

1. Download and install Eclipse Indigo (3.7) from Eclipse website: http://eclipse.org/downloads/
2. Install m2e 1.0 from Eclipse Indigo update site: http://eclipse.org/m2e/
3. Install Scala IDE for Eclipse from: http://www.scala-ide.org/
4. Install Scala m2e connector from: http://alchim31.free.fr/m2e-scala/update-site/m2eclipse-scala/
5. You can also install GoogleAppEngine Eclipse plug-in from: http://code.google.com/intl/fr-FR/appengine/docs/java/tools/eclipse.html but I didn't test this.
6. Finally, you just have to import the project as a Maven project, and perhaps run a `Update project configuration` on it at the end of the import.

You can now use `Run configurations` from Eclipse to launch the project from Maven, or directly use the GoogleAppEngine plugin.

Global informations
-------------------

This project has been initialized using GoogleAppEngine archetype provided by: http://code.google.com/p/gae-mvn-archetype/
GoogleAppEngine integration is done through this Maven plugin: http://code.google.com/p/maven-gae-plugin/