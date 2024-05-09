import { getImageUrl } from '../utils';

export default function Avatar({ person, size = 150 }) {
  return (
    <>
      <img
        className="avatar"
        src={getImageUrl(person)}
        alt={person.name}
        width={size}
        height={size}
      />
    </>
  );
}
