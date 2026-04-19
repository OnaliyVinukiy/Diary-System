public class DatabaseRepositoryFactory implements DiaryRepositoryFactory {
 
    private final String connectionURL;
 
    public DatabaseRepositoryFactory(String connectionURL) {
        this.connectionURL = connectionURL;
    }
 
    @Override
    public DiaryRepository createRepository() {
        return new DatabaseRepository(connectionURL);
    }
}