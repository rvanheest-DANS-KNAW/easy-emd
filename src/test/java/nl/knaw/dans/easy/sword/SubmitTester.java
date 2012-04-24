package nl.knaw.dans.easy.sword;


import nl.knaw.dans.common.lang.mail.Mailer;
import nl.knaw.dans.easy.data.ext.ExternalServices;
import nl.knaw.dans.easy.util.EasyHome;

import org.junit.BeforeClass;
import org.junit.Test;
import org.purl.sword.base.SwordValidationInfo;

import static org.purl.sword.base.SwordValidationInfoType.*;

/** Integration test for the configuration. */
public class SubmitTester extends SubmitFixture
// The name should not start or end with test because Maven should not run this test.
// Why not? The tests require the system property easy.home.
{

    @BeforeClass
    public static void checkEasyHome() throws Exception
    {
        if (EasyHome.getValue() == null)
            throw new Exception("Please specify the system property '" + EasyHome.EASY_HOME_KEY + "'");
    }

    @Test // TODO test was supposed to touch AbstractNotification.send(...)
    public void submitWithoutMailer() throws Exception
    {
        final Mailer saved = ExternalServices.getMailOffice();
        new ExternalServices().setMailOffice(null);
        SwordValidationInfo info = execute(false, false, PROPER_ZIP);
        // TODO upgrade compliancy level to VALID
        assertCompliant(WARNING, info);
        new ExternalServices().setMailOffice(saved);
    }

    @Test
    public void submit() throws Exception
    {
        SwordValidationInfo info = execute(false, false, PROPER_ZIP);
        // TODO upgrade compliancy level to VALID
        assertCompliant(WARNING, info);
    }

    @Test
    public void submitVerboseNoOp() throws Exception
    {
        SwordValidationInfo info = execute(true, true, PROPER_ZIP);
        // TODO upgrade compliancy level to VALID
        assertCompliant(INFO, info);
    }

    @Test
    public void submitNoOp() throws Exception
    {
        SwordValidationInfo info = execute(false, true, PROPER_ZIP);
        // TODO upgrade compliancy level to VALID
        assertCompliant(INFO, info);
    }

    @Test 
    public void spatialMetadata() throws Throwable
    {
        SwordValidationInfo info = execute(false, true, getZip("data-plus-spatial-metadata"));
        // TODO upgrade compliancy level to VALID
        assertCompliant(INFO, info);
    }

    @Test 
    public void whiteSpace() throws Throwable
    {
        SwordValidationInfo info = execute(false, true, getZip("disciplineWithWhiteSpace"));
        // TODO upgrade compliancy level to VALID
        assertCompliant(INFO, info);
    }
}
