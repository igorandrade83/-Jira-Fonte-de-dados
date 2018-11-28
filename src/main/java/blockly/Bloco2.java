package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Bloco2 {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Bloco2
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select LENGTH(u.name) from User u"));
   }
 }.call();
}

}

