import { getImageUrl } from '../utils';

function Card({ children, className = '' }) {
  return <div className={`card ${className}`}>{children}</div>;
}

export default function Profile() {
  return (
    <div>
      <Card>
        <h3>hihihihi</h3>
        <img
          className="avatar"
          src="https://i.imgur.com/OKS67lhm.jpg"
          alt="Aklilu Lemma"
          width={70}
          height={70}
        />
      </Card>
      <Card className="card2">
        <h3>About</h3>
        <p>
          Aklilu Lemma was a distinguished Ethiopian scientist who discovered a
          natural treatment to schistosomiasis.
        </p>
      </Card>
    </div>
  );
}
