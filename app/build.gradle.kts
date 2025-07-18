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
            resValue("string","app_name","XXX Renderer")
            //包名后缀
            //package name Suffix
            applicationIdSuffix = ".xxx"

            //渲染器在启动器内显示的名称
            //The name displayed by the renderer in the launcher
            manifestPlaceholders["des"] = ""
            //渲染器的具体定义 格式为 名称:渲染器库名:EGL库名 例如 LTW:libltw.so:libltw.so
            //The specific definition format of a renderer is ${name}:${renderer library name}:${EGL library name}, for example:   LTW:libltw.so:libltw.so
            manifestPlaceholders["renderer"] = ""

            //特殊Env
            //Special Env
            //DLOPEN=libxxx.so 用于加载额外库文件
            //DLOPEN=libxxx.so used to load external library
            //如果有多个库,可以使用","隔开,例如  DLOPEN=libxxx.so,libyyy.so
            //If there are multiple libraries, you can use "," to separate them, for example  DLOPEN=libxxx.so,libyyy.so
            manifestPlaceholders["boatEnv"] = mutableMapOf<String,String>().apply {

            }.run {
                var env = ""
                forEach { (key, value) ->
                    env += "$key=$value:"
                }
                env.dropLast(1)
            }

            manifestPlaceholders["pojavEnv"] = mutableMapOf<String,String>().apply {

            }.run {
                var env = ""
                forEach { (key, value) ->
                    env += "$key=$value:"
                }
                env.dropLast(1)
            }

            //最小支持的MC版本
            //The minimum supported MC version
            manifestPlaceholders["minMCVer"] = ""
            //最大支持的MC版本
            //The maximum supported MC version
            manifestPlaceholders["maxMCVer"] = ""
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