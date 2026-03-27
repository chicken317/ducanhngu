public class central_hub {

    public void register_device(smart_light light) {
        System.out.println("[HUB] Đang kết nối với thiết bị: " + light.get_name());
    }
}
