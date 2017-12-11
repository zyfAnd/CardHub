# CardHub
Show something like cards with 3 kinds of animations. Two ways to scroll the items:one is scroll normal as listview, other one is scroll to overlap first one.

Screenshot
====
![](/screenshot/screenshot.gif) 

Installation
====
```groovy
dependencies {
    compile 'com.citi.ci.library:cardhub:1.0.2'
}
```

Usages
====
```xml
<com.citi.ci.carhub.CardStackView
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

```java
mStackView = (CardStackView) findViewById(R.id.stackview_main);
mTestStackAdapter = new TestStackAdapter(this);
mStackView.setAdapter(mTestStackAdapter);
mTestStackAdapter.updateData(Arrays.asList(TEST_DATAS));
```

License
====
<pre>
Copyright 2017 Citi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
</pre>
