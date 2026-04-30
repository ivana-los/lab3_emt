import useAuthors from '../hooks/useAuthors';
import EntityCard from '../components/layout/EntityCard';
import LoadingSpinner from '../components/layout/LoadingSpinner';
import ErrorMessage from '../components/layout/ErrorMessage';

const Authors = () => {
    const { authors, loading, error } = useAuthors();

    if (loading) return <LoadingSpinner />;
    if (error)   return <ErrorMessage message={error} />;

    return (
        <div style={{ padding: "2rem" }}>
            <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(200px, 1fr))", gap: 12 }}>
                {authors.map(author => (
                    <EntityCard
                        key={author.id}
                        title={`${author.name} ${author.surname}`}
                        navigateTo={`/authors/${author.id}`}
                        fields={[
                            { label: "Country",   value: author.countryName },
                            { label: "Continent", value: author.continent   },
                        ]}
                    />
                ))}
            </div>
        </div>
    );
};

export default Authors;