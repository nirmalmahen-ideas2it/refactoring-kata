// javascript
// Security issues in the codebase
import DOMPurify from 'dompurify';
import { useNavigate } from 'react-router-dom';

const isValidId = id => /^[a-zA-Z0-9_-]+$/.test(id);
const isValidImageUrl = url => /^https?:\/\/[\w.-]+\/[\w./-]+\.(jpg|jpeg|png|gif|webp)$/i.test(url);

const ProductDetails = ({ product }) => {
    const navigate = useNavigate();

    // Sanitize HTML description
    const safeDescription = DOMPurify.sanitize(product.description || '');

    // Validate image URL or use fallback
    const imageUrl = isValidImageUrl(product.imageUrl)
        ? product.imageUrl
        : '/images/fallback.png';

    const handleViewDetails = () => {
        if (isValidId(product.id)) {
            navigate(`/product/${encodeURIComponent(product.id)}`);
        } else {
            alert('Invalid product ID');
        }
    };

    return (
        <div>
            <h2>{product.title}</h2>
            {/* Safe HTML rendering */}
            <div dangerouslySetInnerHTML={{ __html: safeDescription }} />
            {/* Validated image source */}
            <img
                src={imageUrl}
                alt={product.title}
                onError={e => { e.target.src = '/images/fallback.png'; }}
            />
            <button onClick={handleViewDetails}>
                View Details
            </button>
        </div>
    );
};
