package pl.embe.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Michal_Bucki on 01/04/2015.
 */
@Aspect
public class BeforeExecution {

    @Before("pl.embe.*")
    public void doAccessCheck() {
        System.out.println("Before pl.embe.* execution");
    }

}