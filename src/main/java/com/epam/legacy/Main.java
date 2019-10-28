package com.epam.legacy;

public class Main {


    public static void main(String[] args) {



       /* ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");


        UserService service = (UserServiceImpl) context.getBean("userService");
        System.out.println(service.getAllUsers());*/
        // Save or update operation



      /*  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.refresh();

        UserController userController = ctx.getBean(UserController.class);
        TaskController taskController = ctx.getBean(TaskController.class);
        System.out.println(userController.getUserById(1l));
        //userController.buySubscribe(userController.getUserById(1l));

        userController.signUp(new User(5l, "Dfcz", "Dacz@mail.ru", "123"));
        System.out.println(userController.getUserById(5l));

        System.out.println(userController.getAllUsers());


        taskController.createTask(new Task(4l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        System.out.println(taskController.findTasksByUser(userController.getUserById(1l)));
        taskController.createTask(new Task(5l, "Hi", false, userController.getUserById(1l)), userController.getUserById(1l));
        //userController.buySubscribe(userController.getUserById(1l));
        taskController.createTask(new Task(6l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(7l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(8l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(9l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(10l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(11l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(12l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(13l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        taskController.createTask(new Task(14l,"Hi",false, userController.getUserById(1l)), userController.getUserById(1l));
        //System.out.println(taskController.setTaskPriority(Priority.IMPORTANT, taskController.getTaskById(1l)));*/

    }
}
