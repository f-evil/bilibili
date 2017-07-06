-optimizationpasses 5  # 指定代码的压缩级别
-allowaccessmodification #优化时允许访问并修改有修饰符的类和类的成员
-dontusemixedcaseclassnames  # 是否使用大小写混合
-dontskipnonpubliclibraryclasses  # 是否混淆第三方jar
-dontpreverify  # 混淆时是否做预校验
-verbose    # 混淆时是否记录日志
-ignorewarnings  # 忽略警告，避免打包时某些警告出现
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*  # 混淆时所采用的算法

-obfuscationdictionary dictionary.txt
-classobfuscationdictionary dictionary.txt
-packageobfuscationdictionary dictionary.txt

-keepattributes *Annotation*
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService

-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

-keepclasseswithmembernames class * {  # 保持 native 方法不被混淆
    native <methods>;
}

# Router
-keep class com.chenenyu.router.** {*;}
-keep class * implements com.chenenyu.router.RouteInterceptor {*;}