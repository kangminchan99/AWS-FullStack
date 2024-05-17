export default function Checkbox({ children, checked }) {
  return (
    <label className="checkbox">
      <input type="checkbox" className="blind" defaultChecked={checked} />
      {children}
    </label>
  );
}
