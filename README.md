<pre>

Project .....: GestionInventarioLista
Summary .....: Console CRUD + IN/OUT Item Inventory
Creation ....: 23/06/2024
Author ......: José A. Pacheco Ondoño - joanpaon@gmail.com
Remote ......: https://github.com/joanpaon/GestionInventarioLista.git
IDE .........: NetBeans 22
JDK .........: Oracle JDK 21

To edit this project within NetBeans IDE:

 1. Use the following Scanner object in UtilesEntrada.java library.
 
    public static final Scanner SCN
            = new Scanner(System.in, "UTF-8")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
					
 2. Set the System Environment Variable JAVA_TOOL_OPTIONS as follow:
 
	JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=CP1252 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -Dconsole.encoding=UTF-8

---

To run this project from its generated jar file on a Windows Terminal:

 1. Use the following Scanner object in UtilesEntrada.java library.
 
    public static final Scanner SCN
            = new Scanner(System.in, "CP850")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
					
 2. Create the file run.bat in the directory project with this code inside:
 
	@echo off
	set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=CP1252 -Dsun.stdout.encoding=CP850 -Dsun.stderr.encoding=CP850 -Dconsole.encoding=CP850
	java -jar GestionInventarioLista.jar JAPO-Omicron-0 
 
 3. Run the file run.bat
 
</pre>
