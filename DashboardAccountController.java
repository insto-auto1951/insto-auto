import java.sql.Timestamp;
import java.sql.ArrayList;
import java.util.List;
import java.util.regex.pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.SpringFramework.beans.factory.annotation.Autowired;
import org.SpringFramework.http.Httpstatus;
import org.SpringFramework.http.ResponseEntity;
import org.SpringFramework.web.bind.annotation.Crossorigin;
import org.SpringFramework.web.bind.annotation.PathVariable;
import org.SpringFramework.web.bind.annotation.RequestMapping;
import org.SpringFramework.web.bind.annotation.RequestMethod;
import org.SpringFramework.web.bind.annotation.RequestParam
import org.SpringFramework.web.bind.annotation.ResponseBody;
import org.SpringFramework.web.bind.annotation.RestController;
import org.SpringFramework.web.bind.annotation.Crossorigin;
import io.swagger.annotations.ApiParam;
import java.util.regex.Matcher;
import java.util.regex.Parrern;
/* The DashboardAccountController is a back end rest API for updating the users and execute the processes on demand */ 

/*  I have created backend REST APIs needed to support a web application to that allows a user to view accounts and view account Transaction by using Spring RestController and 
  it performs  create ,read,update and delete the operations */

@Restcontroller
@RequestMapping("/clients") 
public class DashboardAccountController
{
@Autowired
DashboardAccountRepository accountRepository;
@Autowired
private ClientRepository clientRepository;
static final Logger Logger=LogManager.getLogger(DashboardAccountController.class.getName());
/*
create a user
*/
@CrossOrigin
@RequestMapping(method=RequestMethod.POST,value="/{clientId}/users)
@APiOperation(value="To create new user", notes="create a new user based on client Record")
@ResponseBody
public ResponseEntity<AccountRS> createuser(@pathvariable long clientId,@RequestBody UserForm userForm)
{
DashboardAccount account=null;
AccountRS accountRS=null;
Client client=new Client();
if(userform!=null)
{
try{
if(userForm.getDisplayName()==null) || userForm.getDisplayName().equals("")
{
throw new Exception("error");
}
if(userForm.getUsername()==null)||userForm.getUsername().equals(""){
throw new Exception("error");
}
Client=ClientRepository.findone(clientId);
Account=new DashboardAccount();
account.setClient(client);
account.setDisplayname(userForm.getDisplayname());
account.setDisplayImage(userForm.getDispalyImage());
account.setUsername(userForm.getUsername();
account.setaccountExpired(false);
account.setCredentialsExpired(false);
account.setLocked(false);
account.setEnabled(true);
account.setAuthorities("USER");
account.setUpdatedBy("SYSTEM");
account.setCreatedBy("SYSTEM");
//create Response

accountRS=new AccountRS();
accountRS.setAccountID(account.getID);
accountRS.setClientId(account.getclient().getId());
accountRS.setDisplayname(account.getDisplayName());
accountRS.setDisplayImage(account.getdisplayImage());
accountRS.setUsername(account.getusername());
accountRS.setAccountExpired(account.isAccountExpired());

accountRS.setCredentialsExpired(account.iscredentialsExpired();
accountRS.setLocked(account.isLocked());
accountRS.setEnabled(account.isEnabled());
accountRS.setAuthorities(account.getAuthorities());
accountRS.setCreatedTimestamp(account.getCreatedTimestamp());
return new ResponseEntity<AccountRS>(accountRS,Httpstatus.ok);
)
catch(Exception e)
{
Logger.error(e.getmessage());
}
}
else
{
Logger.error("Null submitted");
}
return new ResponseEntity<AccountRS>(accountRS,HttpStatus.BAD_REQUEST);
/*
Find user by Id
*/
@crossorigin
@RequestMapping(method=RequestMethod.GET,value="/{clientId}/users/userId)")
@APiOperation(value="Get the userInformation from the given users",notes="Get the UserInformation from the given users")
public AccountRS getUserBYId(@pathvariable long clientId,@pathvariable long userId)
{
DasbboardAccount account=accountRepository.findByclient_IdAndId(clientId,userId)
AccountRS accountRS=new accountRS();
accountRS.setAccountId(account.getId());
accountRS.setClientId(account.getClient().getId());
accountRS.setDisplayName(account.getDisplayName());
accountRS.setDisplayImage(account.getDisplayImage());
accountRS.setusername(account.isAccountExpired());
accountRS.setcredentialsExpired(account.iscredentialsExpired());
accountRS.setLocked(account.isLocked());
accountRS.setEnabled(account.isEnabled());
accountRS.setAuthorities(account.getAuthorities();
accountRS.setCreatedTimestamp(account.getcreatedTimestamp());
return accountRS;
/*
Update a user
*/
@CrossOrigin
@RequestMapping(method=Requestmethod.PUT,value="/{clierntId}/users/{userId}"}
@APiOpearation(value="Update theuserinformation from the given users",notes="update the userinformation from the userusers")
@ResponseBody
public ResponseEntityu<AccountRS> updateUser(
@Apiparam(value="ClientId",required=true) @pathvariable long ClientId,@Apiparam(value="UserId",required=true) @pathvariable userId, @Apiparam(value="password",required=false) @Requestparam(name="paasword",required=false)
String password,@Apiparam(value="Display Name",required=false) @Requestparam(name="displayName",required=false) String displayName,@Apiparam(value="Display Image,required=false)
@Requestparam(name="displayImage",required=false) String displayImage,@Apiparam("value="Account expired",required=true)
@Requestparam(name="accountExpired",required=true) Boolean accountExpired,@Apiparam(value="credentials Expired",required=true)
@Requestparam(name="credentials",required=true) Boolean credentialsexpired,@Apiparam(value="Locked",required=true) @Requestparam(name="locked",required=true) Boolean locked,
@Apiparam(value="Enabled",required=true) @Requestparam(name="enabled",required=true) Boolean enabled) {
Dashboardaccount account=null;
AccountRS accountrs=null;
try{
account=accountRepository.findById(userId);
if(account!=null){