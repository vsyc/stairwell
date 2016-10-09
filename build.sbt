lazy val root = (project in file(".")).
  settings(
    name := "stairwell",
    version := "0.0.1",
    scalaVersion := "2.11.8",
    mainClass in Compile := Some("com.example.stairwell.Stairwell")
  )

target in assembly := file("/usr/local/jars/")

libraryDependencies ++= Seq()

// META-INF discarding
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
  case n if n.startsWith("reference.conf") => MergeStrategy.concat
  case n if n.endsWith(".conf") => MergeStrategy.concat
}
