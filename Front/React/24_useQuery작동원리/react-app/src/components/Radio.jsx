export default function Radio({ children, checked, onChange, group }) {
  return (
    <label className="radio">
      <input
        type="radio"
        className="blind"
        name={group}
        checked={checked}
        onChange={onChange}
      />
      {children}
    </label>
  );
}
