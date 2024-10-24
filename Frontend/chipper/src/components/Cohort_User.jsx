// import axios from 'axios';
// import { useEffect, useState } from 'react';
// import '../styles/Cohort_User.css'

// const Cohort_User = () => {
//   const [studentScores, setStudentScores] = useState([]);
//   const [loading, setLoading] = useState(true);
//   const [error, setError] = useState(null);

//   useEffect(() => {
//     const fetchStudentScores = async () => {
//       try {
//         const response = await axios.get('http://localhost:8080/userCohort/getStudentScoresByCohort', {
//           params: {
//             cohortId: 987
//           }
//         });
//         setStudentScores(response.data); 
//         setLoading(false);
//       } catch (err) {
//         setError(err);
//         setLoading(false);
//       }
//     };

//     fetchStudentScores();
//   }, []);

//   if (loading) return <div>Loading...</div>;
//   if (error) return <div>Error: {error.message}</div>;

//   return (
//     <div className='flex items-center justify-center'>
//       {/* <h1>Student Scores</h1> */}
//       <table className='border border-gray-900 my-4'>
//         <thead>
//           <tr>
//             <th>ID</th>
//             <th>Name</th>
//             <th>Cohort</th>
//             <th>Activity</th>
//             <th>Score</th>
//           </tr>
//         </thead>
//         <tbody>
//           {studentScores.map((student) => (
//             <tr key={student[0]}>
//               <td>{student[0]}</td>
//               <td>{student[1]}</td>
//               <td>{student[2]}</td>
//               <td>{student[3]}</td>
//               <td>{student[4]}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//   );
// };

// export default Cohort_User;
import axios from 'axios';
import { useEffect, useState } from 'react';
import { Bar, Pie } from 'react-chartjs-2';
import '../styles/Cohort_User.css';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  ArcElement,
} from 'chart.js';

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
  ArcElement
);

const Cohort_User = () => {
  const [studentScores, setStudentScores] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchStudentScores = async () => {
      try {
        const response = await axios.get('http://localhost:8080/userCohort/getStudentScoresByCohort', {
          params: {
            cohortId: 987
          }
        });
        setStudentScores(response.data); 
        setLoading(false);
      } catch (err) {
        setError(err);
        setLoading(false);
      }
    };

    fetchStudentScores();
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error.message}</div>;

  // Extract data for charts
  const cohortDescription = studentScores.length > 0 ? studentScores[0][3] : ''; 
  const names = studentScores.map((student) => `${student[1]} (ID: ${student[0]})`);
  const scores = studentScores.map((student) => student[4]); // Score column

  // Data for the bar chart
  const barData = {
    labels: names,
    datasets: [
      {
        label: 'Scores',
        data: scores,
        backgroundColor: 'rgba(113, 122, 255, 0.8)',
      },
  
    ],
  };

  // Data for the pie chart
  const pieData = {
    labels: names,
    datasets: [
      {
        label: 'Scores',
        data: scores,
        backgroundColor: [
          'rgba(255, 99, 132, 0.6)',
          'rgba(54, 162, 235, 0.6)',
          'rgba(255, 206, 86, 0.6)',
          'rgba(75, 192, 192, 0.6)',
          'rgba(153, 102, 255, 0.6)',
        ],
      },
    ],
  };

  // Options for the bar chart
  const barOptions = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: `Cohort: ${cohortDescription}`,
      },
    },
  };

  // Options for the pie chart
  const pieOptions = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: 'Scores Distribution',
      },
    },
  };

  return (
    <div className='flex items-center justify-center flex-col'>
      <h2 className='text-center my-4'>{cohortDescription}</h2>

      {/* Bar chart */}
      <div style={{ width: '400px' , height: '500px', margin: '0 auto' }}>
        <Bar data={barData} options={barOptions} />
      </div>

      {/* Pie chart */}
      {/* <div style={{ width: '400px', margin: '20px auto' }}>
        <Pie data={pieData} options={pieOptions} />
      </div> */}

      {/* Existing Table */}
      {/* <table className='border border-gray-900 my-4'>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Cohort</th>
            <th>Activity</th>
            <th>Score</th>
          </tr>
        </thead>
        <tbody>
          {studentScores.map((student) => (
            <tr key={student[0]}>
              <td>{student[0]}</td>
              <td>{student[1]}</td>
              <td>{student[2]}</td>
              <td>{student[3]}</td>
              <td>{student[4]}</td>
            </tr>
          ))}
        </tbody>
      </table> */}
    </div>
  );
};

export default Cohort_User;
