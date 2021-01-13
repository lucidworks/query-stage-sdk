package com.lucidworks.querying;

public class SDKVersion {

  private static final String VERSION;

  static {
    Package packageClass = SDKVersion.class.getPackage();
    // Get the implementation version of Query Stage SDK
    VERSION = packageClass.getImplementationVersion();
  }

  public static String getVersion() {
    return VERSION;
  }
}
