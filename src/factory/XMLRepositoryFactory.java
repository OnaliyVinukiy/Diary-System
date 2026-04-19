public class XMLRepositoryFactory implements DiaryRepositoryFactory {

    private final String filePath;

    public XMLRepositoryFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public DiaryRepository createRepository() {
        return new XMLRepository(filePath);
    }
}