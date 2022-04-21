import React, { Component } from 'react';
import '../../css/Careers.css'
import axios from 'axios';
import { MDBDataTable,  } from 'mdbreact';
import { Link } from 'react-router-dom';
export default class Careers extends Component {
    constructor(props){
        super(props);
        this.state = {
            careers: []
        }
        this.tabledata = this.tabledata.bind(this);
        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);
        this.refreshPage = this.refreshPage.bind(this);
    }
    openModal = () => {
      this.setState({ show: true });
    };
    closeModal = () => {
      this.setState({ show: false });
    };
    componentDidMount() {
      this.refreshPage();
  }
    refreshPage() {
      let options = {
          url: "http://localhost:8088/api/career",
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
              careers: response.data
          });
      }).catch(error => {
        console.log(error);
        });
  }; 
  tabledata() {
    let data = {
     columns: [
       {
         label: 'Codigo',
         field: 'codigo',
         sort:  'asc',
          
       },
       {
         label: 'Nombre',
         field: 'nombre',
         sort:  'asc',
          
       },
       {
         label: 'Titulo',
         field: 'titulo',
         sort:  'asc',
       }      
     ],
     rows: this.state.careers   
     }
     for(let i in data.rows){
      let cName = data.rows[i]['nombre'];
      data.rows[i]['nombre'] = <Link to={{ pathname: "/cursos", search: `?codigo=${data.rows[i]['codigo']}` }}>
      {cName}</Link> 
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
