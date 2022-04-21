import React, { Component } from 'react';
import '../../css/Professors.css'
import axios from 'axios';
import { MDBDataTable,  } from 'mdbreact';
import { Link } from 'react-router-dom';
export default class Students extends Component {
    constructor(props){
        super(props);
        this.state = {
            students: []
        }
        this.tabledata = this.tabledata.bind(this);
        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);
        this.updateStudentsSort = this.updateStudentsSort.bind(this);
    }
    openModal = () => {
      this.setState({ show: true });
    };
    closeModal = () => {
      this.setState({ show: false });
    };
    componentDidMount() {
      this.updateStudentsSort();
  }
    updateStudentsSort() {
      let options = {
          url: "http://localhost:8080/api/student",
          method: "GET",
          header: {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
              'Access-Control-Allow-Origin': '*'
          }
      }
      axios(options).then(response => {
          console.log(response.data)
          this.setState({
            students: response.data
          });
      }).catch(error => {
        console.log(error);
        });
  }; 
  tabledata() {
    let data = {
     columns: [
       {
         label: 'Cédula',
         field: 'cedula',
         sort:  'asc',
          
       },
       {
         label: 'Correo',
         field: 'email',
         sort:  'asc',
          
       },
       {
         label: 'Fecha de nacimiento',
         field: 'fech_nac',
         sort:  'asc',
       },
       {
         label: 'Nombre',
         field: 'nombre',
         sort:  'asc',
       },
       {
         label: 'Teléfono',
         field: 'teléfono',
         sort:  'asc',
       }
     ],
     rows: this.state.students   
     } 
     for(let i in data.rows){
      let cName = data.rows[i]['nombre'];
      data.rows[i]['nombre'] = 
      <Link 
        to={{ pathname: "/alumno", search: `?codigo=${data.rows[i]['codigo']}` }}>
        {cName}
      </Link> 
    }     
     return data
}  
    render() {
        return (
            <div>            
              <MDBDataTable                     
                searchLabel='Buscar'
                responsive
                hover={true}
                data={this.tabledata()}              
                />
            </div>
        );
    }
}
