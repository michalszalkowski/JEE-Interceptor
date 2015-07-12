package pl.btbw;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class AppCtrl {

    @Inject
    private PaymentService paymentService;

    @GET
    public String test() {
        paymentService.pay(100);
        paymentService.refund(50);
        return "";
    }
}
