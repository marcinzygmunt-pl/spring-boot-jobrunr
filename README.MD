# Manage Jobs in the Background like a PRO
Background processing in Java with the Job Runr library in Spring Boot.
Benefits:
1. Distributed and supported by persistent storage.
2. Open-source and free for commercial use.
3. Alternative to Spring Batch and Quartz Scheduler, similar to Hangfire for Java and Java CRON scheduler.

## Running & configuration:
### Storage Provider
To work with Job Runr, you need to provide a storage. By default, Runr will attempt to use the default DataSource configuration defined in your Spring Boot project. If you don't have one, you should create one or use InMemoryStorageConfiguration as used in this sample.

### Other properties:
Job Runr also requires some properties to be configured in the application.yml file
- background-job-server.enabled should be set to true
- You can disable the dashboard or set a new port for it:
  ```dashboard:
  enabled: true
  port: 8000
  ```

## Sample jobs
Some default jobs are added when the application starts. Check sample components for:
- Batch Jobs
- Enqueue Jobs
- Scheduled Jobs
  
You can also create jobs from the controller:
- Use /api/schedule to create a new scheduled job
- Use /api/enqueue to enqueue a new job

# Want to learn more? 
 visit [JobRunr webpage](https://www.jobrunr.io//en/)