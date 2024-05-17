export default function Radio({ children, checked, group }) {
  return (
    <label className="radio">
      <input
        type="radio"
        className="blind"
        name={group}
        defaultChecked={checked}
      />
      {children}
    </label>
  );
}
