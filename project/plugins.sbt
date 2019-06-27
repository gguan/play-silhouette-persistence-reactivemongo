// Comment to get more information during initialization
logLevel := Level.Warn

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.3")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.0")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.7")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")

addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.5")

addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.2")
