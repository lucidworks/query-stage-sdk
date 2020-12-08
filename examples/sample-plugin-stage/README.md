# Sample plugin stage.
Sample project with two querying stages. 

* [Sample](src/main/java/com/lucidworks/sample/SampleStage.java) - Stage that is just adding a new query param with 
  specific value to each query request.
* [Update response](src/main/java/com/lucidworks/response/UpdateResponseStage.java) - Stage that is just adding a new field with a specific value to each query response.

This is also a demonstration of a basic gradle project that assembles Fusion query stage plugin zip.

# Build
To create a plugin call ```./gradlew -p examples/sample-plugin-stage assemblePlugin``` from the main folder.
This will create a plugin zip file (with required manifest file) inside the ```build/libs``` folder

# Deploy
You can deploy the example plugins via Fusion UI ("Blobs" section) or by using `deploy` gradle task:

```bash
./gradlew -p examples/sample-plugin-stage deploy -PfusionUser=[user] -PfusionPassword=[password]
```

Alternatively you can also deploy plugin via Fusion REST API by using `curl`:
```bash
curl -u [user]:[password] -X PUT -H "Content-Type:application/zip" --data-binary @sample-plugin-stage-0.0.1.zip https://[fusion url]/api/index-stage-plugins
```

After successful deployment new stages should be visible in the `Stages` list in the Fusion Index Pipelines UI.
