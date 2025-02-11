package test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Condition;
import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPageV2;

import static com.codeborne.selenide.Selenide.$;
import static data.DataHelper.getAuthInfo;
import static data.DataHelper.getFirstCardInfo;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards1() {
        var info = getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(info);
        Selenide.open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var verificationPage = loginPage.validLogin(info);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsNew() {
        var info = getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(info);
        var firstCardInfo = getFirstCardInfo();
        var loginPage = Selenide.open("http://localhost:9999", LoginPageV2.class);
        var verificationPage = loginPage.validLogin(info);
        var dashBoardPage = verificationPage.validVerify(verificationCode);
        var firstCardBalance = dashBoardPage.getCardBalance(firstCardInfo);
    }

    @Test
    void selectionOfCardsForReplenishment() {
        var info = getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(info);
        var firstCardInfo = getFirstCardInfo();
        var loginPage = Selenide.open("http://localhost:9999", LoginPageV2.class);
        var verificationPage = loginPage.validLogin(info);
        var dashBoardPage = verificationPage.validVerify(verificationCode);
        var firstCardBalance = dashBoardPage.getCardBalance(firstCardInfo);
        $("button.button").click();
        $("[data-test-id= 'amount'] input").setValue("500");
        $("[data-test-id= 'from'] input").setValue("5559 0000 0000 0002");
        $("button.button").click();

    }
}









