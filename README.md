# springBatch

This repo is dedicated to Spring and Spring Batch.

Spring batch is a spring utility library that assists developers with chunk or batch processing of high volume data processing. The utility of this package is to design and implement a solution that has stringent performance & scalability requirements, and low latency extreme transaction processing.

An example of this is the Banking industry, where processing is done using scheduled events and daily sync of transactions.

There are Jobs(transactions) and Steps(n) involved in many aspects of data processing. A job is processed and can have 1-to-many steps to complete the transaction. There are two type of step in processing a job in Spring Batch.

 - Tasklet Steps: small unit steps or tasks like you might see in a workflow. See BPMN Workflows
 - Chunk-Oriented Steps: (Chunk steps) - this would be an example of processing a large import file. A tasklet step could also be in the form of a chunk step.
 
 	- chunk size: It is not practical to process the entire import file. Therefore the file is processed in a chunk-by-chunk fashion. 
	- input type(s): events(kafka), csv, etc
	- Chunk Step has 3 defined parts, definition:
 		- item reader: consume to produce
 		- item processor(optional): Business logic transaction processing
	 	- item writer: consumer to produce 
	 	
   ![Alt text](./spring_batch_overviewIO.jpg?raw=true "Spring Batch Overview")

Execution Context: Map of Metadata KV Pairs for persisted state of the execution.
  	
In SpringBatch there are two execution contexts:
  1) Step scope context - StepExecution object
  1) Job scope context - JobExecution object - provides inter-step communication or values/variables from step-2-step.  

