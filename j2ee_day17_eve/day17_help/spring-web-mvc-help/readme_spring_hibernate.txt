1.Create dyn web project
2. Add Jars.
3. Modify web.xml -- to add DispatcherServlet entry 
<servlet>
    <servlet-name>spring</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>spring</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>

4. Create main spring configuration xml file --- with servletName-servlet.xml under <web-inf> ---- add beans,context & mvc namespaces.

5. Add tags -- context:annotation-config,context:component-scan,mvc:annotation-driven(to enable annotated MVC controller support)

6. Declare view resolver bean in xml config file  --- Can use InternalResourceViewResolver or its super-class ---UrlBasedViewResolver --- Props are same for both beans --- viewClass(choose JSTL view for JSP view templates), prefix -- typically under web-inf & suffix -- .jsp
<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
<property name="prefix" value="/WEB-INF/pages/" />
<property name="suffix" value=".jsp" />
</bean>
	
7. Create separate hibernate configuration file(under <resources> & import it in main config file -- add bean,context,p,tx namespaces to hibernate cfg xml file

8. Configuration steps for persistence.
8.1 create database properties file & store it under run-time class path(either directly under src or under source folder) --consists of ---driver class name,db url, user name & password.

8.2 Supply  location of db properties file using 
<context:property-placeholder location="classpath:/db.properties" />

8.3 Create data source bean --- using apache supplied cn pool based datasource.

<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="${db.driver}" p:url="${db.url}" p:username="${db.username}"
		p:password="${db.password}" p:initialSize="1" p:maxActive="2"
		destroy-method="close">
</bean>

8.4 Create Hibernate session factory bean
<bean id="sessionFactory"
		class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="annotatedClasses">
			<list>
				<value>Fully Qualified POJO class name </value>
			</list>
		</property>
		<property name="hibernateProperties">
			<value>
				hibernate.format_sql=true
				hibernate.show_sql=true
			</value>
		</property>
	</bean>

	

8.5
To enable annotated transaction supprt(spring container managed txs)
<tx:annotation-driven/>
8.6 Declare transaction mgr bean by injecting session factory bean ref into it.
<bean id="transactionManager" 		class="org.springframework.orm.hibernate4.HibernateTransactionManager">
<property name="sessionFactory" ref="sessionFactory" />
</bean>

This finishes config steps

9. Identify persistence requirements -- create annotated pojos or use rev eng to generate it.(class level annotation --- @Entity)
(As in struts 2 -- since POJO represents db cols & also request parameters -- match property names with rq param names . Can optionally also add P.L validation annotations (eg -- @NotNull, @NotEmpty , @Range etc....)

10. Create DAO layer i/f & add implementation class -- annotate DAO layer with @Repository annotation.

Inject (using @AutoWired or @Resource) , hib's session factory into DAO impl bean.

Just as in case of JPA based DAO(SLSB/SFSB facade) , simply use ready made session factory instance to --- get current session --- use Session api for CRUD(eg --- createQuery,save,update,delete )

11. Create Service layer (optional but recommended --- since u can keep tx management dtls separate from DAO layer)
Create service i/f & its implementation class. -- annotated with @Service class level annotation. 
This layer simply invokes DAO layer methods
Additional method level annotation --- org.springframework.transaction.annotation.Transactional
@ can supply --- readonly sts,tx propagation,isolation,timeout,rollback rules etc.

12. Create spring request controller layer --- annotated with @Controller.  
Inject service layer.
Can have additional annotations as -- @RequestMapping , @Valid, etc.
Controller will invoke service layer method & results can be stored into model (rq scoped) or session scoped attribute , as per B.L
13. Using MVC -- view is rendered, which displays results from DB



