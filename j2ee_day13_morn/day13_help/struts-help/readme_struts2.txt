Struts 2.3.7

What is struts
 
Its MVC based web application framework -- based upon (Filter as a front Controller ) MVC .
Vendor - Apache
NOT J2EE specified. 
Why Struts 2 ? 

The Struts MVC framework is created for developers - to build servlets or JSPs  in which database code, page design code and control flow code is not mixed .

Applications that have code intermixed - are difficult to maintain as they grow larger. 
Model I--- NO pattern -- no fixed separation)
Model II -- proper separation.(MVC)

The Struts framework is based on the MVC architecture, which helps developers create dynamic Web applications with clear separation of concerns.(concerns = tasks or logic)

Struts2 -- is not part of J2EE specifications.
BUT its used as WAF (web appln frmwork) for creating dyn web applns or enterprise applns.
-------------------------------------

The Struts 2 framework provides -
1.Controller - It has its  own  Web front controller component for handling control-flow logic.

 2. View - can  integrate with JSPs (including JSTL and JSF), Velocity Template Engine and XSLT,PDF....

2. Model - Based on Business actions ---for persistence uses technologies such as JDBC, EJB, Hibernate or iBATIS for data access.

What is Struts 2 ?
Struts 2 is Struts 1(Apache supplied modified/enhanced version ) + XWork2(Open Symphony community supplied)
org.apache.struts2
com.opensysmphony.xwork2




What are Jobs of FilterDispatcher/StrutsPrepareAndExecuteFilter
(org.apache.struts2.dispatcher.FilterDispatcher/org.apache.struts2.dispatcher.ng.filter )
Its Master filter for Struts.(main entry point to struts 2 architecture)

 Executes actions
Creates &  Cleans up the ActionContext 
 Serves static content
 Starts XWork's interceptor chain for the  request lifecycle

What is ActionContext ?
(com.opensymphony.xwork2.ActionContext)

The ActionContext is the context(env)  in which an Action is executed. Each context contains objects an action needs for execution like the session, parameters, locale, etc.

The ActionContext is thread local ---  which means that values stored in the ActionContext are unique per thread. 
i.e Progs need not worry about thread safety.

Struts 2 features 

1. Improved design: Unlike Struts 1, all of the Struts 2 classes are based on interfaces. Core interfaces are HTTP independent , not dependent on Servlet APIs.

2. Simplified Actions: Struts 2 Action classes are framework independent and are simple POJOs.  Any Java class with an execute() method can be used as an Action class.

3. Intelligent defaults:Most of the config elems will have def. vals. So reduces the XML config. Also supports annotations , to achieve zero-config.
    

4. Introduction to  interceptors: Struts 2 provides support for interceptors. 
They  can be executed before and after an Action class is executed. 
Interceptors are configured to apply common functionality(concerns)  such as workflow or validation, file upload etc.  All the requests pass through a set of interceptors before they are sent to an Action class. After the Action class is executed, the response passes through the interceptors again in the reverse order.
    

5 Ajax support: To create dynamic Web applications that use Ajax, Struts 2 provides an Ajax theme.

6. QuickStart: Deployed configuration files are reloadable; hence, many changes can be made on the fly without the need to restart the Web container.
   
7.  Stateful checkboxes: The Struts 2 framework automatically tracks checkboxes; if a checkbox is missing, the default value -- false -- is assumed. 
     
8. Easy testing: Struts 2 Actions are HTTP independent and thus framework neutral. They can be tested easily without using mock objects.

9. Easy integration with Spring: Struts 2 Actions are Spring-aware. Just adding Spring beans to an application adds Spring support.

Struts 2 architecture basics

Based on MVC architecture.

Its a flexible control layer based on standard technologies such as Java filters, JavaBeans, ResourceBundles, Locales and XML + Open Symphony packages like OGNL(Object Graph Navigation language)  and XWork.

Model - Sturts 2 actions can integrate with any standard data access technologies such as JDBC,EJB,Hibernate, iBATIS 

View - Frmwork can use JavaServer Pages (including JSTL and JSF), Velocity templates, PDF, XSLT and FreeMarker for rendering view.

Exception handlers - can be declared in config xmls -  for defining a global exception and a local exception.  no need to write try/catch blocks in the code .  The framework catches each exception and displays a page with an appropriate message and exception details.
eg - 
<global-results>
<result name="exception123">Error.jsp</result>
</global-results>
<global-exception-mappings>
<exception-mapping exception="java.lang.Exception" result="exception123"/>
</global-exception-mappings>

Main Additional components of Struts 2 archiecture (added after Struts 1)

1. Interceptors -  specify the request-processing life cycle for an action. Interceptors specify the sequence of actions that happen before and after the Action class is executed. Used to apply common functionality to a request. They  allow common, cross cutting tasks to be
defined in clean, re-usable components that you can keep separate from your action code.
eg : logging,params,conversion,validations,file-upload,workflow,i18n...

2. ValueStack --- Struts 2 uses the ValueStack as a storage area for all application  data that will be needed during the processing of a request.

Simple Basics --- 
After client send request --- 
Struts(SPEF) creates ActionInvocation Object
ActionInvocation Object creates
1. Action class instance(either prog supplied or default ActionSupport)
2. Sets up interceptors to be fired before action's execute style method & after response (result) is generated.
3.
 For each action invocation , ActionContext object is created before execute method of action(which contains B.L logic --supplied by Prog.)  is called.
It stores action & other objects.
Structure of Thread Local ActionContext

--- Contains Stack of Objects(eg action,model object --- object 0, object 1 ....object n ) -- commonly referred to as Value Stack  + 
Context Map --- contains following

1 parameters --- rq param map
2 request -- rq scoped attr map
3 session --- session scoped attr map
4 application --application scoped attr map
5 attr --- map that searches for attrs in order req,session,application

2.1 Data is stored on  to the ValueStack during  rq. processing done by the inetrceptors.
2.2 V.S is Updated during action execution.
2.3 Read from there when the results render their response pages.

3. OGNL --Struts 2 's powerful expression language. 
Used to read & update properties on the ValueStack.
Example usage -- Can use  OGNL to bind HTML form fields to data objects on the ValueStack for data transfer.
Can use OGNL to pull data into the rendering of your JSP's and other result types.

Prefix # if u want to access objs from Context map
eg : In struts 2 -- below will get value of action propery named ---  email
 <s:property value="email"/>

below will get value of Rq param named email : <s:property value="#parameters.email"/> 

below will get value of appln scoped attr name use_list(if its a HM then can extract keys using keySet() or values using values())
<s:property  value="#application.user_list.values()"/>

below will get value of session scoped attr set by Business action class.
<s:property  value="#session.u_dtls"/>
Struts 2 request processing flow
Simpler flow ---
  1.

      When the user performs an action on the Web application, the Web browser sends a request for some resource to the Web server.
   2.

      The request is received by the servlet filter dispatcher(SPEF), which looks at the request and determines the appropriate Action to be invoked to serve it.
   3.

      The set of interceptors configured for applying some common functionality to the request -- validation, workflow, or file upload etc - are automatically applied to the request before the Action's execute (style) method is executed.
   4.

      A new instance of the Action class is located/loaded/instantiated and then the action's exec  method is executed for storing or retrieving information to or from a database.
   5.

      The output -- be it HTML, images, PDF, or in some other format -- is rendered by the result.
   6.

      Then the request traverses through the interceptors in the reverse order. The returning request allows for the performance of additional processing or clean-up operations.
   7.

      Finally, the container sends the output to the browser.

Detailed internals -----

1. Clnt request goes to the servlet container (eg Tomcat WC).
where it is then passed through a chain of filters.
 
2. 1st filter - Passes optionally thro' ActionContextCleanUp filter -used only  when integrating with other technologies such as Site Mesh plug-ins. 

3. Req. passes to FilterDispatcher(servlet-filter, replaced by StrutsPrepareAndExecuteFilter). F.D. uses the ActionMapper to determine if  there is a need to invoke an action for this request. If the ActionMapper determines that an Action should be invoked, the FilterDispatcher delegates the control to the ActionProxy.

4.The ActionProxy consults the framework configuration files manager(which is  initialized from the user created struts.xml file). 

5.Then the ActionProxy creates an ActionInvocation, which is responsible for implementing the command pattern. The ActionInvocation process invokes the required interceptors(before the action)  and then invokes an Action.

6. When   Action is executed - i.e  typically : execute() will be called & it rets the result of the business logic.


7. ActionInvocation matches the returned result code with proper result (JSP) associated with the Action - by consulting struts.xml.
eg : of typical action config in struts.xml
pass-thro' action - invokes JSP directly
<action name="Name">           			<result>NameCollector.jsp</result>
</action>	
proper action - Here if the execute() from actions.HelloWorld rets 'SUCCESS' , then ActionInvocation
<action name="HelloWorld" class="actions.HelloWorld">
<result name="SUCCESS">/HelloWorld.jsp</result>
</action>

8.Result page (mostly JSP is rendered) is then executed.

9. Interceptors are executed again after completing the Action in the reverse order. The response returns through the filters configured in web.xml. 

10.Either of the ActionContextCleanUp filter or FilterDispatcher will clean up ThreadLocal ActionContext (i.e everything asso with current req + resp) 

Imp concepts ---
1.
Introduction to  interceptors: Struts 2 provides support for interceptors. 
They  can be executed before and after an Action class is executed. 
Interceptors are configured to apply common functionality(concerns)  such as workflow or validation, file upload etc.  All the requests pass through a set of interceptors before they are sent to an Action class. After the Action class is executed, the request passes through the interceptors again in the reverse order.

some std interceptors ----params
validator
file-upload
exception
workflow
i18n
modeldriven

Which are  different result types typically used ?
1. default type=dispatcher --- typically meant for to JSP/HTML

2. type=chain ---- for action chaining.
eg : <action name="action1" class="....">
<result type="chain">action2</result>
</action>

Meaning ---action1 is chianed to action2  -- action1 & action2 are both on value stack, having action2 obj sitting at top.
(action scope not yet over)

3.type="redirect" --- re-directs to new resource, in next request.
equivalent to sendRedirect
Redirection removes asso with earlier action , as redirection has new URL
eg --
<action name="test" class="...">
        <result type="redirect">user_inp.action?nm=${user_nm}</result>
    </action>
or 
<action name="test" class="...">
        <result type="redirect">display.jsp</result>
    </action>


4. type=redirectAction ---- sendRedirect for new action.
eg 
  <-- Redirect to an action in the same namespace -->
    <action name="dashboard" class="...">
        <result>dashboard.jsp</result>
        <result name="abc" type="redirectAction">error</result>
    </action>
	<action name="abc" class="...">
        <result>error.jsp</result>
    </action>


More on Interceptors
The request processing lifecycle of Struts2 framework 

    Request is generated by user and sent to Servlet container.
    Servlet container invokes StrutsPrepareAndExecutFilter filter which in turn determines appropriate action.
    One by one Intercetors are applied before calling the Action. Interceptors performs tasks such as Logging, Validation, File Upload, Double-submit guard etc.
    Action is executed and the Result is generated by Action.
    The output of Action is rendered in the view (JSP, Velocity, etc) and the result is returned to the user.

Thus the Struts2 Interceptors removes cross cutting tasks such as logging from action components and create cleaner separation of MVC.

Struts2 comes with default list of Interceptors already configured in the application in struts-default.xml file. We can create our own custom Interceptors and plugin into a Struts2 based web application.

Framework creates an object of ActionInvocation that encapsulates the action and all the interceptors configured for that action. Each interceptors are called before the action gets called. Once the action is called and result is generated, each interceptors are again called in reverse order to perform post processing work. Interceptors can alter the workflow of action. It may prevent the execution of action.

Description of 
An initial request goes to the Servlet container (such as Tomcat) which is passed through a standard filter chain. The chain includes the (optional) ActionContextCleanUp filter, which is useful when integrating technologies such as SiteMesh Plugin. Next, the required FilterDispatcher is called, which in turn consults the ActionMapper to determine if the request should invoke an action.

If the ActionMapper determines that an Action should be invoked, the FilterDispatcher delegates control to the ActionProxy. The ActionProxy consults the framework Configuration Files manager (initialized from the struts.xml file). Next, the ActionProxy creates an ActionInvocation, which is responsible for the command pattern implementation. This includes invoking any Interceptors (the before clause) in advance of invoking the Action itself.

Once the Action returns, the ActionInvocation is responsible for looking up the proper result associated with the Action result code mapped in struts.xml. The result is then executed, which often (but not always, as is the case for Action Chaining) involves a template written in JSP or FreeMarker to be rendered. While rendering, the templates can use the Struts Tags provided by the framework. Some of those components will work with the ActionMapper to render proper URLs for additional requests.
	

Interceptors are executed again (in reverse order, calling the after clause). Finally, the response returns through the filters configured in the web.xml. If the ActionContextCleanUp filter is present, the FilterDispatcher will not clean up the ThreadLocal ActionContext. If the ActionContextCleanUp filter is not present, the FilterDispatcher will cleanup all ThreadLocals.



