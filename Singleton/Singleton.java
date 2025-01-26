/*package Singleton;

public class Singleton {
    private Singleton singletonObject;
    private void Singleton() {}

    public static synchronized Singleton getSingletonInstance() {
        if(singletonObject == null) {
            singletonObject = new Singleton();
        }
        return singletonObject;
    }
}

*/
/*
 Imagine you are designing a RESTful API for a task management application. 
 The application should allow users to manage their tasks,
  with the ability to create new tasks, retrieve a list of their tasks, update task details, 
  complete a task, and delete a task. Additionally, users should be able to assign tasks to other 
  users and retrieve a list of tasks assigned to them.

For each of the functionalities described, specify the appropriate HTTP method, 
the URI (endpoint), and the expected HTTP status codes for both successful operations and 
common error cases.

Entities - Task, User

Task - create task, retrieve a list of their tasks, update task details, complete a task, delete a task

REST APIs

createTask
v1/tasks
POST
{
    name,
    description,
    status - 
}
return 201 -

retrieve a list of their tasks
v1/tasks/?page=1
GET
{}
return 200

update task details
v1/tasks/{id}
PUT
{
    updated Task Payload
}
return 20X

complete a task - we are only updating task status
PATCH
v1/tasks/{id}/status
{
    status
}
return 20X

delete a task
DELETE
v1/tasks/{id}
{id}
return 201

user - users should be able to assign tasks to other users, retrieve a list of tasks assigned to them
assign task to user -> taskId is added to their list
PUT
v1/users/{id}
{
    taskId
}
return 20X

get list of all tasks assigned to user - /users/{id}/tasks
GET
/users/{id}/tasks
{}


Employee class -> departmentId, employee salary, employee name

List<Employee> employees

employees.stream().map(employee -> {employee.getDepartmentId()}).collectFirst(toSet())

Sinleton

Strategy - 

Commad Design Pattern - 

Command() {
    execute()
}

CreateTaskCommand {
    execute()
}
UpdateTaskCommand {
    execute()
}

Observer Pattern
topic - list<subscribers> 
subscribers to a topic
 
 */
 