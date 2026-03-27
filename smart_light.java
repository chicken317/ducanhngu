public class smart_light {
    
    private String id;
    private String name;
    private int brightness;

    public smart_light(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    public smart_light(String id, String name) {
        this(id, name, 50);
    }

    public String get_id() {return id;}
    public String get_name() { return name; }
    public int get_brightness() {return brightness;}

    public void set_brightness(int new_brightness) {
        this.brightness = new_brightness;
    }

    public void set_brightness(String preset) {
        if      ( preset == "MAX") {this.set_brightness(100);}
        else if ( preset == "MIN" ) {this.set_brightness(10);}
        else if ( preset == "ECO") {this.set_brightness(30);}
    }

    public void connect_to_hub(central_hub hub) {
        hub.register_device(this);
    }

    public static void main(String[] args) {
        central_hub hub = new central_hub();
        smart_light l1 = new smart_light("L01", "Den Phong Khach", 80);
        smart_light l2 = new smart_light("L02", "Den ngu");

        l2.set_brightness("ECO");

        l1.connect_to_hub(hub);
        l2.connect_to_hub(hub);

        System.out.println(" l1:" + l1.get_brightness() + " l2: " + l2.get_brightness());
    }
}
