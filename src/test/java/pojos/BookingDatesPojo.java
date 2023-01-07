package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

    //1- Tum key'ler icin private variable'lar olusturuyoruz
    private String checkin;
    private String checkout;

    // Tum variable'larla  parametreli ve parametresiz Constructor olus.
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    //3- Public Getter ve Setter olus.

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    // 4- toString methodu olus.
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin +
                ", checkout='" + checkout +
                '}';
    }
}
