import { useState, useEffect } from 'react';
import { sliceArrayByLimit } from '../lib/utils.js';
import styles from './Pagination.module.css';

export default function Pagination({ page, setPage, totalPage, limit }) {
  const [currentPageArray, setCurrentPageArray] = useState([]);
  const [totalPageArray, setTotalPageArray] = useState([]);

  useEffect(() => {
    if (page % limit === 1) {
      setCurrentPageArray(totalPageArray[Math.floor(page / limit)]);
    } else if (page % limit === 0) {
      setCurrentPageArray(totalPageArray[Math.floor(page / limit) - 1]);
    }
  }, [limit, page, totalPageArray]);

  useEffect(() => {
    const slicedPageArray = sliceArrayByLimit(totalPage, limit);
    setTotalPageArray(slicedPageArray);
    setCurrentPageArray(slicedPageArray[0]);
  }, [limit, totalPage]);

  return (
    <div className={styles.pagination}>
      {page !== 1 && (
        <button type="button" onClick={() => setPage(page - 1)}>
          이전
        </button>
      )}
      {currentPageArray?.map((num) => (
        <button
          key={num}
          type="button"
          onClick={() => setPage(num + 1)}
          className={`${styles.num_btn} ${
            page === num + 1 ? styles.active : ''
          }`}
        >
          {num + 1}
        </button>
      ))}
      {page !== totalPage && (
        <button type="button" onClick={() => setPage(page + 1)}>
          다음
        </button>
      )}
    </div>
  );
}
