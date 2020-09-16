package com.hibernate.spring;

import java.util.UUID;

public class MainApp {



  public static void main(String[] args) {
    // AnnotationConfigApplicationContext context =
    // new AnnotationConfigApplicationContext(HibernateConfig.class);
    // EntityManagerFactory factory = context.getBean(EntityManagerFactory.class);
    // EntityManager manager = factory.createEntityManager();


    // DisplayService displayService = context.getBean(DisplayService.class);
    // displayService.add(new Display(UUID.randomUUID().toString(), "name1", "status1", "url1",
    // "Member1", "2020-01-01", "Admin", "2020-02-02", "Y", null));
    // displayService.add(new Display(UUID.randomUUID().toString(), "name2", "status2", "url2",
    // "Member2", "2020-01-02", "Admin", "2020-02-02", "y", null));
    // displayService.add(new Display(UUID.randomUUID().toString(), "name3", "status3", "url3",
    // "Member3", "2020-01-03", "Admin", "2020-02-02", "N", null));
    // displayService.add(new Display(UUID.randomUUID().toString(), "name4", "status4", "url4",
    // "Member4", "2020-01-04", "Admin", "2020-02-02", "n", null));


    // List<Display> displays = displayService.listDisplays();
    // for (Display display : displays) {
    // System.out.println(display.toString());
    // }

    System.out.println(UUID.randomUUID().toString());

  }
}
