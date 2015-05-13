# Remember

An in-memory data store backed by shared preferences, for Android.


## What this is

A key-value store with some nice properties:

1. Speed. Everything is stored in-memory so reads can happen on the UI thread. Writes and deletes happen asynchronously (with callbacks). Every public method is safe to call from the UI thread.

2. Durability. Writes get persisted to disk, so that this store maintains state even if the app closes or is killed.

3. Consistency. Doing a write followed by a read should return the value you just put.

4. Thread-safety. Reads and writes can happen from anywhere without the need for external synchronization.

Note that since writes are asynchronous, an in-flight write may be lost if the app is killed before the data has been written to disk. If you require true 'commit' semantics then Remember is not for you.


## Usage

Pre-requisite: Your project must have [Guava](https://github.com/google/guava) installed. In your app's `build.gradle` file, add it to your dependencies:

```groovy
dependencies {
    compile 'com.google.guava:guava:18.0'
}
```

When your app starts up, initialize Remember. This only has to be done once, and should happen in your app's `onCreate()`:

```java
Remember.init(getContext(), "com.mysampleapp.whatever");
```

Then call it 

```java
Remember.putString("some key", "some value");
String value = Remember.getString("some key");
```

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
