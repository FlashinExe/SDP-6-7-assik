public class CloudSaverAdapter implements DocumentSaver {
    private final LegacyCloudService legacy;

    public CloudSaverAdapter(LegacyCloudService legacy) { this.legacy = legacy; }

    @Override
    public void save(String content) {
        byte[] data = content.getBytes(StandardCharsets.UTF_8);
        legacy.upload(data);
    }
}
