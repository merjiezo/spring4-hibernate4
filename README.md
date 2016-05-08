>使用spring4+hibernate4制作的demo

麻雀虽小，五脏俱全，里面有数据库的增删查改，以及在整合过程中碰到的一些坑，可以说作为最新版本，整合起来可以说很困难，还有一些设置的原因，传模型到jsp页面的时候，发生了${  }不能被识别的问题，所有的所有让我意识到java的严谨。在PHP编写中不会出现的问题，在java里面就很明显。

>制作了数据库操作基类，使用了事务，今后会添加切面

```java
public Boolean execute(String sql, Session session) throws Exception {
    Boolean result = true;
    session.beginTransaction();
    try {
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
        session.getTransaction().commit();
    } catch(Exception e) {
        result = false;
        session.getTransaction().rollback();
        throw new Exception("Hibernate Transaction failed", e);
    } finally {
        session.close();
    }
    return result;
}

public Boolean insert(Object object, Session session) throws Exception {
    Boolean result = true;
    session.beginTransaction();
    try {
        session.save(object);
        session.getTransaction().commit();
    } catch(Exception e) {
        System.out.println(e.getMessage());
        result = false;
        session.getTransaction().rollback();
        throw new Exception("Hibernate Transaction failed", e);
    } finally {
        session.close();
    }
    return result;
}
```

>制作了json接口，通过servlet和springMVC做了整合

```java
@RequestMapping(value="/jsontest")
public void JsonTestController(HttpServletResponse res) throws ServletException, IOException {
    res.setHeader("Content-type", "application/json");
    String str = "{\"JsonKey\":\"JsonValue\", \"BooleanTest\":true}";
    PrintWriter pw = res.getWriter();
    pw.println(str);
    pw.close();
}
```

