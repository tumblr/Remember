# Remember

An in-memory data store backed by shared preferences, for Android.

This is a key-value store with some nice properties:

1. Speed. Everything is loaded into memory so reads can happen on the UI thread. Writes and deletes happen asynchronously (with callbacks). Every public method is safe to call from the UI thread.

2. Durability. Writes get persisted to disk, so that this store maintains state even if the app closes or is killed.

3. Consistency. Doing a write followed by a read should return the value you just put.

4. Thread-safety. Reads and writes can happen from anywhere without the need for external synchronization.

Note that since writes are asynchronous, an in-flight write may be lost if the app is killed before the data has been written to disk. If you require true 'commit' semantics then Remember is not for you.

## Download

Grab the artifact via [Jitpack](https://jitpack.io/). Include Jitpack as a repository in your build.gradle file:

```groovy
repositories {
    maven {
        url 'https://jitpack.io'
    }
}
```

And add Remember to your dependencies:

```groovy
dependencies {
    compile 'com.github.tumblr:Remember:v1.0'
}
```

## Usage

When your app starts up, initialize Remember. This only has to be done once, and should happen in your app's `onCreate()`:

```java
@Override
public void onCreate() {
    super.onCreate();
    Remember.init(getApplicationContext(), "com.mysampleapp.whatever");
}
```

(Note that this is the Application-level [`onCreate()`](http://developer.android.com/reference/android/app/Application.html#onCreate()), **NOT** the Activity `onCreate()`. Check out the [sample app](https://github.com/tumblr/Remember/blob/master/sample-app/src/main/java/com/tumblr/remembersample/SampleApp.java) for an example.)

Now you can freely use Remember from anywhere in your app:

```java
Remember.putString("some key", "some value");
String value = Remember.getString("some key", "");
```

## Javadoc

Right [here](https://cdn.rawgit.com/tumblr/Remember/ab1870c008e5d96d51ce2655da3f20b59fd82fa5/doc/index.html)

## Sample app
Clone and build this repo in Android Studio to see an example of a sample app. The app simply increments a counter stored in Remember and tells you the value.

## Contact

Michael Lapadula: mlapadula@tumblr.com

## License

```
Copyright 2015 Tumblr, Inc.

Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the License. You may obtain a copy of the License at apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
```
