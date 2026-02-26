rootProject.name = "HoloUX-Workspace"

include(":HoloUI")
project(":HoloUI").projectDir = file("HoloUI")

include(":SneakyMannequins-Plugin")
project(":SneakyMannequins-Plugin").projectDir = file("SneakyMannequins")
