plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.mio.plugin.renderer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mio.plugin.renderer"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        configureEach {
            //应用名
            //app name
            resValue("string","app_name","GL4ES Renderer")
            //包名后缀
            //package name Suffix
            applicationIdSuffix = ".gl4es"

            //渲染器在启动器内显示的名称
            //The name displayed by the renderer in the launcher
            manifestPlaceholders["des"] = "Holy-GL4ES(Legacy/旧版)"
            //渲染器的具体定义 格式为 名称:渲染器库名:EGL库名 例如 LTW:libltw.so:libltw.so
            //The specific definition format of a renderer is ${name}:${renderer library name}:${EGL library name}, for example:   LTW:libltw.so:libltw.so
            manifestPlaceholders["renderer"] = "GL4ES:libgl4es.so:libEGL.so"
            manifestPlaceholders["boatEnv"] = mutableMapOf<String,String>().apply {
                put("LIBGL_ES", "2")
                put("LIBGL_MIPMAP", "3")
                put("LIBGL_NORMALIZE", "1")
                put("LIBGL_NOINTOVLHACK", "1")
                put("LIBGL_NOERROR", "1")
            }.run {
                var env = ""
                forEach { (key, value) ->
                    env += "$key=$value:"
                }
                env.dropLast(1)
            }

            manifestPlaceholders["pojavEnv"] = mutableMapOf<String,String>().apply {
                put("LIBGL_ES", "2")
                put("LIBGL_MIPMAP", "3")
                put("LIBGL_NORMALIZE", "1")
                put("LIBGL_NOINTOVLHACK", "1")
                put("LIBGL_NOERROR", "1")
                put("POJAV_RENDERER", "opengles2")
            }.run {
                var env = ""
                forEach { (key, value) ->
                    env += "$key=$value:"
                }
                env.dropLast(1)
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
}