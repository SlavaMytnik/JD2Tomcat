package org.example.tomcat1.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.example.tomcat1.controller.command.impl.ChangeLocal;
import org.example.tomcat1.controller.command.impl.GoToEditPage;
import org.example.tomcat1.controller.command.impl.GoToIndexPage;
import org.example.tomcat1.controller.command.impl.GoToMainPage;
import org.example.tomcat1.controller.command.impl.GoToNewsPage;
import org.example.tomcat1.controller.command.impl.GoToRegistrationPage;
import org.example.tomcat1.controller.command.impl.Logination;
import org.example.tomcat1.controller.command.impl.Logout;
import org.example.tomcat1.controller.command.impl.DeleteNews;
import org.example.tomcat1.controller.command.impl.ModifyNews;
import org.example.tomcat1.controller.command.impl.GoToRedirectPage;
import org.example.tomcat1.controller.command.impl.SaveNewUser;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.GOTONEWSPAGE, new GoToNewsPage());
		commands.put(CommandName.GOTOEDITPAGE, new GoToEditPage());
		commands.put(CommandName.MODIFYNEWS, new ModifyNews());
		commands.put(CommandName.CHANGELOCAL, new ChangeLocal());
		commands.put(CommandName.DELETENEWS, new DeleteNews());
		commands.put(CommandName.GOTOREDIRECTPAGE, new GoToRedirectPage());
	}	
	
	public Command takeCommand(String name) {
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		
		return commands.get(commandName);
	}
}
