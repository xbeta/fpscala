# Ch.7 Purely Functional Parallelism


## General NOTES:
- Design a purely functional library with an API described by an algebra that
  obeys specific laws and admits no side effects
- Remember that function arguments are strictly evaluated from LTR
- How do you do a stack track on a function call in scala?
- Contructing descriptions strictly but delaying evaluation will result in
  heavy weight trees
- There are trade offs when designing an API. One helpful trick is to think
  about what sort of information is required to implement a function and the
  impact that this choice has on your API design

## Design Process:
- Define problem space, propose solution, test, iterate
- Create a Par type that wraps around an existing Java concurrency primative,
  ExecutorService
  * create a unit function to wrap Par around other types
  * create a get function to extract result of a Par
- Find that Scala's strict evalutation impacts our API design
  * create a fork function that allows a programmer to explictly manage thread creation
  * fork is lazy evaluated allowing us to delay spawning threads until we're ready
  * marks an unevaluated Par for concurrent evaluation
- Prefer to delay extraction of results from a concurrent process to prevent
  side effects
- Creates a strict and nonstrict version of unit using fork
- Par is a decription of a parallel computation that gets interpreted at a later
  time by a get function vs. Par as a container of a value that we can call get
  on when it becomes available.
  * Par doesn't need to know how to implement the parallelism
  * Implementation can be shifted to existing Java concurrency libraries
- Make Par a pure data structure. Create a run function that holds the
  implementation details: spawning new threads, delegating tasks to a thread
  pool, ect.,

## Questions:
- p.101-102: How do you keep map2 strict but not have it begin execution
  immediately? How do make descriptions more lightweight?
  * map2 is lazy evaluated


## MISC
- Good primer on Java/Scala concurrency --
  http://www.ibm.com/developerworks/library/j-jvmc1/index.html
