public class CSVRepositoryFactory implements DiaryRepositoryFactory {
 
    private final String filePath;
 
    public CSVRepositoryFactory(String filePath) {
        this.filePath = filePath;
    }
 
    @Override
    public DiaryRepository createRepository() {
        return new CSVRepository(filePath);
    }
}
 